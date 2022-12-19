<h1>Redis cheat sheet</h1>

<h3>Redis config file</h3>
<pre>
on linux: /etc/redis
on windows: Actually I dont know where it is, but you can see this page😘
<a href="https://stackoverflow.com/questions/28443515/redis-on-windows-config-file">stackOverFlow</a>
</pre>

<h3>Redis command</h3>
<p>
<code>redis-server</code> for start redis server <br>
<code>redis-cli</code> for connect to redis command line 
</p>

<h3>Redis Cli Command</h3>
<pre>
<h4>String:</h4>

APPEND key value------------------append a value to a key
BITCOUNT key [start end]----------count set bits in a string
SET key value---------------------set value in key
SETNX key value-------------------set if not exist value in key
SETRANGE key offset value---------overwrite part of a string at key starting at the specified offset
STRLEN key------------------------get the length of the value stored in a key
MSET key value [key value ...]----set multiple keys to multiple values
MSETNX key value [key value ...]--set multiple keys to multiple values, only if none of the keys exist
GET key---------------------------get value in key
GETRANGE key value----------------get a substring value of a key and return its old value
MGET key [key ...]----------------get the values of all the given keys
DEL key --------------------------delete key

EXPIRE key 120--------------------key will be deleted in 120 seconds
TTL key   

<h4>Integer or Float:</h4>
INCR key--------------------------increment value in key
INCRBY key increment--------------increment the integer value of a key by the given amount
INCRBYFLOAT key increment---------increment the float value of a key by the given amount
DECR key--------------------------decrement the integer value of key by one
DECRBY key decrement--------------decrement the integer value of a key by the given number
DEL key---------------------------delete key

<h4>Hashes:</h4>
Hashes are maps between string fields and string values, so they are the perfect data type to represent objects.
HGET key field----------------get the value of a hash field
HGETALL key   ----------------get all the fields and values in a hash
HSET key field value----------set the string value of a hash field
HSETNX key field value--------set the string value of a hash field, only if the field does not exists

HINCRBY key field increment---increment value in hash by X
HDEL key field [field ...]----delete one or more hash fields
HEXISTS key field-------------determine if a hash field exists
HKEYS key---------------------get all the fields in a hash
HLEN key----------------------get all the fields in a hash
HSTRLEN key field-------------get the length of the value of a hash field
HVALS key  

HMSET key field value [field value ...]---set multiple fields at once

<h4>Lists:</h4>
A list is a series of ordered values.

RPUSH key value [value ...]------------put the new value at the end of the list
RPUSHX key value-----------------------append a value to a list, only if the exists
LPUSH key value [value ...]------------put the new value at the start of the list
LRANGE key start stop------------------give a subset of the list
LINDEX key index-----------------------get an element from a list by its index
LINSERT key BEFORE|AFTER pivot value---insert an element before or after another element in a list
LLEN key-------------------------------return the current length of the list
LPOP key-------------------------------remove the first element from the list and returns it
LSET key index value-------------------set the value of an element in a list by its index
LTRIM key start stop-------------------trim a list to the specified range
RPOP key-------------------------------remove the last element from the list and returns it
RPOPLPUSH source destination-----------remove the last element in a list, prepend it to another list and return it
BLPOP key [key ...] timeout------------remove and get the first element in a list, or block until one is available
BRPOP key [key ...] timeout------------remove and get the last element in a list, or block until one is available
</pre>