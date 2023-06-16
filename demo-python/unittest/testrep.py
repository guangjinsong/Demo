import unittest
from HTMLTestRunner import HTMLTestRunner

# 使用套件对象, 加载对象, 加载对象去添加用例方法
suite = unittest.defaultTestLoader.discover(".", "testpara.py")

# 实例化, 第三方的运行对象, 并运行套件对象
# stream=sys.stdout, 必填,测试报告的文件对象(open ), 注意点,要使用 wb 打开
# verbosity=1, 可选, 报告的详细程度,默认 1 简略, 2 详细
# title=None, 可选, 测试报告的标题
# description=None 可选, 描述信息, Python 的版本, pycharm 版本
# file = 'report.html' # 报告名.html
file = 'report1.html'
with open(file, 'wb') as f: # 必须以b(二进制)的方式打开文件(就不用指定encoding了)
    # runner = HTMLTestRunner(f)  # 运行对象
    runner = HTMLTestRunner(f, 2, "测试报告")
    # 运行对象执行套件 , 要卸载with的缩进中(因为需要文件打开, 才能往文件里面写入)
    runner.run(suite)
