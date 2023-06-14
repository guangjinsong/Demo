"""
学习TestSuite和TestRunner
"""
# 1. 导包
import unittest

from unittest.case.testcase1 import TestDemo1
from unittest.case.testcase2 import TestDemo2

# 2. 实例化
suite = unittest.TestSuite()

# 3. 使用套件对象添加用例方法
# 方法1: 套件对象.addTest(测试类名('方法名'))
#       建议: 测试类名和方法名直接去复制,不要手写
# suite.addTest(TestDemo1('test_method1'))
# suite.addTest(TestDemo1('test_method2'))
# suite.addTest(TestDemo2('test_method1'))
# suite.addTest(TestDemo2('test_method2'))

# 方法2: 套件对象.addTest(unittest.makeSuite(测试类名))
#       会把所有的测试类中测试方法放进去
suite.addTest(unittest.makeSuite(TestDemo1))
suite.addTest(unittest.makeSuite(TestDemo2))



# 4. 实例化运行对象
runner = unittest.TextTestRunner()

# 5. 使用运行对象去执行套件对象
#    运行对象.run(套件对象)
runner.run(suite)