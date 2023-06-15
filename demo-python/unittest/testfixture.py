import unittest


class TestLogin(unittest.TestCase):
    def setUp(self):
        print("输入网址....")
        pass

    def tearDown(self):
        print("关闭网址...")

    @classmethod
    def setUpClass(cls) -> None:
        print('打开浏览器')

    @classmethod
    def tearDownClass(cls) -> None:
        print('关闭浏览器')

    def test_1(self):
        print("输入正确用户名密码验证码, 点击登录 1")

    def test_2(self):
        print("输入正确用户名密码验证码, 点击登录 2")
