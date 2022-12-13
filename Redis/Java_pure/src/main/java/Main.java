import connection.JedisConnection;
import redis.clients.jedis.Jedis;

public class Main {
    public static void main(String[] args) {
        Jedis jedis = JedisConnection.getInstance().getJedis();
        System.out.println("Connection to server successfully");
        jedis.set("key", "value");
        System.out.println(jedis.get("key"));
    }
}
