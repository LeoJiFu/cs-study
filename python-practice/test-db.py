# This is a sample Python script.

# Press ⇧F10 to execute it or replace it with your code.
# Press Double ⇧ to search everywhere for classes, files, tool windows, actions, and settings.
import pyodbc

def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press ⌘F8 to toggle the breakpoint.

    server = 'fypserverdb.database.windows.net'
    database = 'FYP_Database'
    username = 'FYP_Admins'
    password = '126269_Team!'
    port = '1433'
    driver = '{ODBC Driver 17 for SQL Server}'

    connectionStr = 'DRIVER='+driver+';SERVER='+server+';PORT=1433;DATABASE='+database+';UID='+username+';PWD='+ password
    print(connectionStr)

    with pyodbc.connect(connectionStr) as conn:
        with conn.cursor() as cursor:
            cursor.execute("SELECT TOP 3 * FROM student")
            row = cursor.fetchone()
            while row:
                print(str(row[0]) + " " + str(row[1]))
                row = cursor.fetchone()



# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi('PyCharm')

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
