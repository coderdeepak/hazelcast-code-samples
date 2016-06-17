

import java.util.Map;
import java.util.Queue;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;


/**
 * 
 * @author deepak.keswani
 * Create a simple Java application using the Hazelcast distributed map and queue.
 *
 */
public class GettingStarted {

	/**
	 * On executing this application an instance of hazelcast is created at port 5701.
	 * 	    Members [1] {
				Member [172.20.235.103]:5701 - 17135d9b-efc4-4fe3-a02f-9acdda3d5085 this
			}
			
			
		Run it twice to have a cluster with 2 members. Another instance of hazelcast is created and joined the cluster. 
			Members [2] {
				Member [172.20.235.103]:5701 - 17135d9b-efc4-4fe3-a02f-9acdda3d5085 this
				Member [172.20.235.103]:5702 - 891e6a51-9ed3-4a87-8d67-27be85b04cd3
			}	
	 * 
	 */
	public static void main(String[] args) {
		HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
	    Map<Integer, String> customers = hazelcastInstance.getMap( "customers" );
	    customers.put( 1, "Joe" );
	    customers.put( 2, "Ali" );
	    customers.put( 3, "Avi" );

	    System.out.println( "Customer with key 1: " + customers.get(1) );
	    System.out.println( "Map Size:" + customers.size() );

	    Queue<String> queueCustomers = hazelcastInstance.getQueue( "customers" );
	    queueCustomers.offer( "Tom" );
	    queueCustomers.offer( "Mary" );
	    queueCustomers.offer( "Jane" );
	    System.out.println( "First customer: " + queueCustomers.poll() );
	    System.out.println( "Second customer: "+ queueCustomers.peek() );
	    System.out.println( "Queue size: " + queueCustomers.size() );
	}

	/**
	 * By default, Hazelcast uses Multicast to discover other members that can form a cluster. 
	 * If you are working with other Hazelcast developers on the same network, 
	 * you may find yourself joining their clusters under the default settings. 
	 * 
	 * Hazelcast provides a way to segregate clusters within the same network when using Multicast. 
	 * Please see the Creating Cluster Groups for more information. 
	 * 
	 * Alternatively, if you do not wish to use the default Multicast mechanism, 
	 * you can provide a fixed list of IP addresses that are allowed to join. 
	 * Please see the Join Configuration section for more information.
	 */
	
}

