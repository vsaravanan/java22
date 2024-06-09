package console.designpatterns.objectpool;

/**
 * @author Sarav on 07 May 2024
 * @project govtech
 * @package com.govtech.viswa.designpatterns.objectpool
 * @class ObjectPool
 */
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Resource class (Example: Database Connection)
class Resource {
    // Resource-specific attributes and methods
}

// Object Pool
class ObjectPool {
    private BlockingQueue<Resource> pool;
    private int maxSize;

    public ObjectPool(int maxSize) {
        this.maxSize = maxSize;
        this.pool = new LinkedBlockingQueue<>(maxSize);
        initializePool();
    }

    private void initializePool() {
        for (int i = 0; i < maxSize; i++) {
            pool.offer(new Resource()); // Use offer() to avoid blocking
        }
    }

    public Resource acquireResource() throws InterruptedException {
        System.out.println("Acquiring resource from the pool...");
        Resource resource = pool.take(); // Blocking call, waits until a resource is available
        System.out.println("Resource acquired: " + resource);
        return resource;
    }

    public void releaseResource(Resource resource) {
        System.out.println("Releasing resource back to the pool: " + resource);
        pool.offer(resource); // Use offer() to avoid blocking
    }
}

// Client code
public class ObjectPoolTest {
    public static void main(String[] args) {
        ObjectPool objectPool = new ObjectPool(10);

        try {
            // Acquire resources from the pool
            Resource resource1 = objectPool.acquireResource();
            Resource resource2 = objectPool.acquireResource();

            // Use resources

            // Release resources back to the pool
            objectPool.releaseResource(resource1);
            objectPool.releaseResource(resource2);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.err.println("Failed to acquire resource: " + e.getMessage());
        }
    }
}
