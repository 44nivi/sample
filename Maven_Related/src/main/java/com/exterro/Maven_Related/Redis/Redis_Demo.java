package com.exterro.Maven_Related.Redis;

import java.util.List;
import java.util.Set;
import redis.clients.jedis.Jedis;

public class Redis_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Connecting to Redis server on localhost
		Jedis jedis = new Jedis("localhost", 6379);

		jedis.lpush("nivi3", "Redis1");
		jedis.lpush("nivi3", "Mongodb2");
		jedis.lpush("nivi3", "Mysql3");
		jedis.lpush("nivi3", "[1,2,3,4]");
		List<String> list = jedis.lrange("nivi3", 0, 10);

		System.out.println("Connection to server sucessfully");
		// check whether server is running or not
		System.out.println("Server is running: " + jedis.ping());
		
		
		  for(int i = 0; i<list.size(); i++) {
		  System.out.println("Stored string in redis:: "+list.get(i)); }
		 
		
		/*
		 * Set<String> keys=jedis.keys(pattern); for (String key : keys) {
		 * jedis.del(key);
		 */
	}
}
