# Understanding ConcurrentHashMap: Buckets and Concurrency

## Buckets and Segments

### Buckets
When you insert a key-value pair into a `ConcurrentHashMap`, the map uses a hash function to determine which "bucket" to place the entry into. A bucket is essentially a slot or a container within the map where the entry is stored. Multiple keys might map to the same bucket if their hash values are similar.

### Segments (in older versions of Java)
Earlier versions of `ConcurrentHashMap` (before Java 8) used a concept called "segments." The map was divided into segments, and each segment acted like an independent `Hashtable`. Each segment had its own lock, so multiple threads could operate on different segments simultaneously without interfering with each other. This significantly reduced contention compared to locking the entire map.

## Post Java 8

### Fine-Grained Locking
In Java 8, `ConcurrentHashMap` was redesigned to remove segments and instead uses fine-grained locking at the bucket level. It achieves this by locking only a specific bucket when a write operation (like `put`) is performed, allowing other threads to read and write to different buckets concurrently. This further reduces contention and improves performance.

## How Buckets Handle Concurrency

### Separate Locks
Each bucket (or a small group of buckets) can be locked independently, meaning threads can operate on different parts of the map at the same time without waiting for each other.

### CAS (Compare-And-Swap) Operations
In some cases, `ConcurrentHashMap` uses CAS operations to update the map without locking. CAS allows a thread to update a value only if it hasn't been modified by another thread since it was last read. This helps in reducing the need for locking, making operations faster.
