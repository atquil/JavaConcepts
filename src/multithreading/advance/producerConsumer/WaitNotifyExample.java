package multithreading.advance.producerConsumer;

class Message {
    private String message;
    private boolean empty = true;

    public synchronized String read() {
        // Wait until a message is available.
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        // Mark the message as read.
        empty = true;
        // Notify all waiting threads that the message has been read.
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        // Wait until the previous message has been read.
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        // Mark the message as not empty.
        empty = false;
        // Write the new message.
        this.message = message;
        // Notify all waiting threads that a new message is available.
        notifyAll();
    }
}

class WaitNotifyExample {
    public static void main(String[] args) {
        Message message = new Message();

        // Create a thread that writes messages to the object.
        Thread writer = new Thread(new Runnable() {
            public void run() {
                String messages[] = {
                        "Message 1",
                        "Message 2",
                        "Message 3",
                        "Message 4"
                };
                for (int i = 0; i < messages.length; i++) {
                    // Write a message to the object.
                    message.write(messages[i]);
                    try {
                        // Sleep for 2 seconds between messages.
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {}
                }
                // Write a final message to indicate that writing is finished.
                message.write("Finished");
            }
        });

        // Create a thread that reads messages from the object.
        Thread reader = new Thread(new Runnable() {
            public void run() {
                for (String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read()) {
                    System.out.println(latestMessage);
                }
            }
        });

        // Start both threads.
        writer.start();
        reader.start();
    }
}
