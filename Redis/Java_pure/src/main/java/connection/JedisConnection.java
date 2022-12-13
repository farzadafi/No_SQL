package connection;

import redis.clients.jedis.Jedis;

public class JedisConnection {

    private static Jedis jedis = null;

    private static final JedisConnection jedisConnection = new JedisConnection();

    private JedisConnection() {
        if (jedis == null) {
            String ip = "127.0.0.1";
            int port = 6379;
            //JedisPoolConfig config = new JedisPoolConfig();
            jedis = new Jedis(String.format("redis://%s:%s", ip, port));
        }

    }

    public Jedis getJedis() {
        return jedis;
    }

    public static JedisConnection getInstance() {
        return jedisConnection;
    }
}
