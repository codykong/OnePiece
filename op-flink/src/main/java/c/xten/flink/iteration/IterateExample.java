package c.xten.flink.iteration;

import c.xten.flink.wordcount.WordCount;
import c.xten.flink.wordcount.WordCountData;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/4/25
 * Time: 下午3:37
 */
public class IterateExample {

    public static void main(String[] args) throws Exception {
        final ParameterTool params = ParameterTool.fromArgs(args);

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment()
                .setBufferTimeout(1);

        env.getConfig().setGlobalJobParameters(params);

        DataStream<String> text;

        if (params.has("input")) {
            text = env.fromElements(WordCountData.WORDS);
        } else {
            System.out.println("Executing Iterate example with default input data set.");
            System.out.println("Use --input to specify file input.");
            text = env.addSource(new RandomSource());
        }

        DataStream<Tuple2<String, Integer>> counts =
                text.flatMap(new WordCount.Tokenizer()).setParallelism(2)
                        .keyBy(0)
                        .sum(1);

        if (params.has("output")) {
            counts.writeAsText(params.get("output"));
        } else {
            System.out.println("Printing result to stdout. Use --output to specify output path.");
            counts.print();
        }


        env.execute("IterateExample");

    }


    public static class RandomSource implements SourceFunction<String> {

        Random random = new Random();

        @Override
        public void run(SourceContext<String> sourceContext) throws Exception {
            for (int i = 0; i<10000;i++){
                sourceContext.collect(String.valueOf(random.nextInt(10)));
                Thread.sleep(100);
            }
        }

        @Override
        public void cancel() {

        }
    }

}
