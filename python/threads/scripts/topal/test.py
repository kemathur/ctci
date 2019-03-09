from time import time, sleep


def do_some_work(i, n=10000000):
    print ("Started:  ", i)
    sum = 0
    for j in range(n):
        sum += j*(j-1)/(j+1)
    print ("Finished: ", i)


def main():
    ts = time()
    do_some_work()
    print ("Took: ", time()-ts)


if __name__ == '__main__':
    main()
