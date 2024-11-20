# coding:utf-8
from mrjob.job import MRJob
import csv

class MRYesNoConverter(MRJob):

    def mapper(self, _, line):
        reader = csv.reader([line])
        '''
        [1, 2, 3, 4]
        [5, 6, 7, 8]
        '''
        rows = list(reader)
        for row in rows[1:]:
            for item in row:
                if item in ["No", "Female"]:
                    item = 0
                elif item in ["Yes", "Male"]:
                    item = 1
                

    def reducer(self, _, rows):
        for row in rows:
            yield None, row

if __name__ == '__main__':
    MRYesNoConverter.run()


'''
python DealDate.py -r hadoop hdfs:///graduationDesign/heart_cleaned.csv -o hdfs:///graduationDesign/output
'''
