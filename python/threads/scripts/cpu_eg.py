from queue import Queue
from threading import Thread
from time import time

def do_some_work(i, n=3000000):
    sum = 0
    for j in range(n):
        sum += j*(j-1)/(j+1)


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


def work(nthreads=1):
    ts = time()
    queue = Queue()
    for x in range(8):
        worker = Worker(queue)
        worker.daemon = True
        worker.start()

    for i in range(10):
        queue.put(i)

    queue.join()
    print ("Took: ", time() - ts)


def main():
    print ("single threaded: ")
    work(1)
    print ("=======================")
    print ("multi threaded: ")
    work(4)
    print ("=======================")


if __name__ == '__main__':
    main()
