# 1. 导包
import unittest


# 2. 自定义测试类 需要继承unittest模块中的TestCase类
class TestDemo1(unittest.TestCase):
    # 3. 书写测试用例方法. 书写要求: 测试方法必须以test_开头(本质是以test开头)
    def test_method1(self):
        print("测试方法 1-1")

    def test_method2(self):
        print("测试方法 1-2")

# 4. 执行用例
# 4.1 第一种方法: 将光标放在类名的后边运行, 会执行类中所有的测试方法
# 4.2 第二种方法: 将光标放在方法名的后边运行, 只执行对应的测试方法
