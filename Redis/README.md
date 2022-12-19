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
String:

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
INCR key--------------------------increment value in key
DEL key --------------------------delete key

EXPIRE key 120--------------------key will be deleted in 120 seconds
TTL key   
</pre>