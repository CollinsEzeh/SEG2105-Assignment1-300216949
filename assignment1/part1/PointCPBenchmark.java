package part1;

import java.util.Arrays;
import java.util.Random;
import java.util.function.ToDoubleFunction;

public class PointCPBenchmark {

    public static void main(String[] args) {
        Monitor<PointCP2> m1 = new Monitor<>("PointCP2",
            PointCP2::new, random -> random.nextDouble() * 10.0D, random -> random.nextDouble() * 10.0D,
            PointCP2::getX, PointCP2::getY, PointCP2::getRho, PointCP2::getTheta
        );

        Monitor<PointCP3> m2 = new Monitor<>("PointCP3.java",
            PointCP3::new, random -> random.nextDouble() * Math.PI * 2.0D, random -> random.nextDouble() * 1000.0D,
            PointCP3::getX, PointCP3::getY, PointCP3::getRho, PointCP3::getTheta
        );

        System.out.println(m1.name + ": " + m1.execute(100000000, 1234L));
        System.out.println(m2.name + ": " + m2.execute(100000000, 1234L));
    }

    public static class Monitor<T> {
        private final String name;
        private final Constructor<T> constructor;
        private final ToDoubleFunction<T> x;
        private final ToDoubleFunction<T> y;
        private final ToDoubleFunction<T> rho;
        private final ToDoubleFunction<T> theta;
        private final ToDoubleFunction<Random> aGen;
        private final ToDoubleFunction<Random> bGen;

        public Monitor(String name, Constructor<T> constructor,
                       ToDoubleFunction<Random> aGen, ToDoubleFunction<Random> bGen,
                       ToDoubleFunction<T> x, ToDoubleFunction<T> y,
                       ToDoubleFunction<T> rho, ToDoubleFunction<T> theta) {
            this.name = name;
            this.constructor = constructor;
            this.aGen = aGen;
            this.bGen = bGen;
            this.x = x;
            this.y = y;
            this.rho = rho;
            this.theta = theta;
        }

        public Result execute(int iterations, long seed) {
            Result result = new Result();
            result.iterations = iterations;
            Random random = new Random(seed);
            final double[] blackHole = {0.0D};

            for(int i = 0; i < iterations; i++) {
                double a = this.aGen.applyAsDouble(random);
                double b = this.bGen.applyAsDouble(random);

                long xTime = this.getRunTime(() -> blackHole[0] += this.x.applyAsDouble(this.constructor.construct(a, b)));
                result.xTime += xTime;
                if(xTime < result.xTimeMin) result.xTimeMin = xTime;
                if(xTime > result.xTimeMax) result.xTimeMax = xTime;

                long yTime = this.getRunTime(() -> blackHole[0] += this.y.applyAsDouble(this.constructor.construct(a, b)));
                result.yTime += yTime;
                if(yTime < result.yTimeMin) result.yTimeMin = yTime;
                if(yTime > result.yTimeMax) result.yTimeMax = yTime;

                long rhoTime = this.getRunTime(() -> blackHole[0] += this.rho.applyAsDouble(this.constructor.construct(a, b)));
                result.rhoTime += rhoTime;
                if(rhoTime < result.rhoTimeMin) result.rhoTimeMin = rhoTime;
                if(rhoTime > result.rhoTimeMax) result.rhoTimeMax = rhoTime;

                long thetaTime = this.getRunTime(() -> blackHole[0] += this.theta.applyAsDouble(this.constructor.construct(a, b)));
                result.thetaTime += thetaTime;
                if(thetaTime < result.thetaTimeMin) result.thetaTimeMin = thetaTime;
                if(thetaTime > result.thetaTimeMax) result.thetaTimeMax = thetaTime;
            }

            //Stops JIT optimizations
            System.out.println("black hole " + Arrays.toString(blackHole));
            return result;
        }

        private long getRunTime(Runnable task) {
            long start = System.nanoTime();
            task.run();
            return System.nanoTime() - start;
        }

        public interface Constructor<T> {
            T construct(double a, double b);
        }
    }

    public static class Result {
        private int iterations;
        private long xTime;
        private long yTime;
        private long rhoTime;
        private long thetaTime;
        private long xTimeMin = Integer.MAX_VALUE;
        private long yTimeMin = Integer.MAX_VALUE;
        private long rhoTimeMin = Integer.MAX_VALUE;
        private long thetaTimeMin = Integer.MAX_VALUE;
        private long xTimeMax = Integer.MIN_VALUE;
        private long yTimeMax = Integer.MIN_VALUE;
        private long rhoTimeMax = Integer.MIN_VALUE;
        private long thetaTimeMax = Integer.MIN_VALUE;

        @Override
        public String toString() {
            return String.format("%f [%d, %d] | %f [%d, %d] | %f [%d, %d] | %f [%d, %d]",
                (double)this.xTime / this.iterations, this.xTimeMin, this.xTimeMax,
                (double)this.yTime / this.iterations, this.yTimeMin, this.yTimeMax,
                (double)this.rhoTime / this.iterations, this.rhoTimeMin, this.rhoTimeMax,
                (double)this.thetaTime / this.iterations, this.thetaTimeMin, this.thetaTimeMax);
        }
    }

}
