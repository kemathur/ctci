from queue import Queue
from threading import Thread
from time import time

from test import do_some_work


class Worker(Thread):
    
    def __init__(self, queue):
        Thread.__init__(self)
        self.queue = queue


    def run(self):
        while True:
            # Get work from queue
            i = self.queue.get()
            try:
                do_some_work(i)
            finally:
                self.queue.task_done()


def main():
    ts = time()
    queue = Queue()
    for x in range(8):
        worker = Worker(queue)
        worker.daemon = True
        worker.start()

    for i in range(10):
        print ("Scheduling: ", i)
        queue.put(i)

    queue.join()
    print ("Took: ", time() - ts)


if __name__ == '__main__':
    main()
