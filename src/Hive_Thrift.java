
import org.apache.thrift.protocol.TProtocol;

import java.util.List;

import org.apache.hadoop.hive.service.HiveClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
public class Hive_Thrift {

	public static void main(String[] args) throws Exception {
		final TSocket tSocket=new TSocket("192.168.10.101", 10008);
		final TProtocol tProtocol=new TBinaryProtocol(tSocket);
		final HiveClient client=new HiveClient(tProtocol);
		
		tSocket.open();
		client.execute("desc t1");
		List<String> columns=client.fetchAll();
		for(String col:columns)
		{
			System.err.println(col);
		}
		tSocket.close();
		
	}
}
