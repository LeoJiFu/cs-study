class DBService:

    def __init__(self, arg1, arg2, arg3):
        # Init a dictionary to simulate a in memory storage
        print('DBService init')
        self.storage = arg1
        self.name = arg2
        self.connectionString = arg3

        self.pingDB()

    def pingDB(self):
        # odbc
        # // self.connectionString
        if self.connectionString != '':
            return 'ok'

    # def __init__(self):
    #     # Init a dictionary to simulate a in memory storage
    #     print('DBService init')
    #     self.storage = {}
    #     self.name = 'DBService'


    @staticmethod
    def staticMethod1():
        return 'abcd dsfb sdfsf'


    def insertStorage(self, student):
        self.storage[student.name] = {'age': student.age}
        print(self.storage)

    def fetchStudentInfo(self, student):

        if student.name == '':
            return False

        # sql
        pass
















