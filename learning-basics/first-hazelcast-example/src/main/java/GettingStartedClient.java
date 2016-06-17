

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * 
 * @author deepak.keswani
 * The following code starts a Hazelcast Client, connects to our cluster, 
 * and prints the size of the customers map.
 *
 */
public class GettingStartedClient {

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
        HazelcastInstance client = HazelcastClient.newHazelcastClient( clientConfig );
        IMap map = client.getMap( "customers" );
        System.out.println( "Map Size:" + map.size() );
	}
	/**
	 * When you run it, you see the client properly connecting to the cluster and 
	 * printing the map size as 3.
	 * 
	 */

}
