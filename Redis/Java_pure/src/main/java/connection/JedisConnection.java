package connection;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class JedisConnection {

    private static JedisPool pool = null;

    private static final JedisConnection jedisConnection = new JedisConnection();

    private JedisConnection() {
        if (pool == null) {
            String ip = "127.0.0.1";
            int port = 6379;
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(10000);
            config.setMaxIdle(2000);
            config.setMaxWait(Duration.ofDays(1));
            config.setTestOnBorrow(true);
            pool = new JedisPool(config, ip, port, 100000);
        }

    }

    public Jedis getJedis() {
        return pool.getResource();
    }

    public static JedisConnection getInstance() {
        return jedisConnection;
    }
}
