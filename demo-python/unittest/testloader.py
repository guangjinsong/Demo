# 1. 导包
import unittest

# 2. 实例化加载对象并添加用例
# discover('用例所在路径', '用例的代码文件名')
# 用例所在的路径, 建议使用相对路径, 用例的代码文件名可以使用*(任意多个任意字符)通配符
suite = unittest.TestLoader().discover('./case', 'te*.py') #以te开头的文件
# suite = unittest.defaultTestLoader.discover('case', 'te*.py') # 另一种创建对象的方式

# 3. 实例化运行对象
runner = unittest.TextTestRunner()

# 4. 执行
runner.run(suite)