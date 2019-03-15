import time
import os
import logging
from urllib.parse import urlparse
from urllib.request import urlretrieve
from threading import Thread
from queue import Queue

import PIL
from PIL import Image

class Downloader(object):
    def __init__(self, home_dir='.', nthreads=4):
        self.home_dir = home_dir
        self.input_dir = self.home_dir + os.path.sep + 'incoming'
        self.output_dir = self.home_dir + os.path.sep + 'outgoing'
        self.download_queue = Queue()
        self.nthreads = nthreads

    # download each image and save to the input dir
    def download_image(self):
        while True:
            url = self.download_queue.get()
            img_filename = url.split('/')[-1].split('=')[1]+'.jpeg'
            urlretrieve(url, self.input_dir + os.path.sep + img_filename)
            self.download_queue.task_done()

    def download_images(self, img_url_list):
        # validate inputs
        if not img_url_list:
            return
        os.makedirs(self.input_dir, exist_ok=True)
        threads = []
        for i in range(self.nthreads):
            t = Thread(target=(self.download_image), daemon=True)
            t.start()
            threads.append(t)
        print("beginning image downloads")

        start = time.perf_counter()
        for url in img_url_list:
            # download each image and save to the input dir 
            self.download_queue.put(url)
        self.download_queue.join()
        end = time.perf_counter()
        
        print("downloaded {} images in {} seconds".format(len(img_url_list), end - start))


if __name__ == "__main__":
    IMG_URLS = ["https://picsum.photos/500/?image="+str(i) for i in range(20)]
    print ("Single threaded download:")
    Downloader(nthreads=1).download_images(IMG_URLS)
    print ("=============================")
    print ("Multi threaded download: ")
    Downloader(nthreads=4).download_images(IMG_URLS)
    print ("=============================")


