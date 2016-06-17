import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        
         // Finds hazelcast.xml in class path and instantiate an instance of it. hazelcast-network-config.xml contains the network properties. 
    	HazelcastInstance member = Hazelcast.newHazelcastInstance();
        
    	HazelcastInstance client = HazelcastClient.newHazelcastClient();

        Thread.sleep(1000);
        System.out.println("after sleep");
        client.shutdown();
        member.shutdown();
    }
}
