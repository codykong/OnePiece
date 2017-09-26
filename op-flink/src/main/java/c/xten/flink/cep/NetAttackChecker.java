package c.xten.flink.cep;

import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/4/17
 * Time: 下午4:33
 */
public class NetAttackChecker {

    public static void main(String[] args) {

        final ParameterTool params = ParameterTool.fromArgs(args);
        final StreamExecutionEnvironment env =StreamExecutionEnvironment.getExecutionEnvironment();

//        env.addSource(
//                new MonitorEventSource()
//        )




    }

}
