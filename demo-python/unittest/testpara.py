import json
import unittest
from parameterized import parameterized


def login(str1, str2):
    return '登录成功'
    pass


# 组织测试数据
# data = [('admin', '123456', '登录成功')]


def build_data():
    with open('data.json', encoding='utf-8') as f:
        result = json.load(f)
        data = []
        for i in result:
            data.append((i.get("username"), i.get("password"), i.get("expect")))
    return data


# 定义测试类
class TestLogin(unittest.TestCase):
    # 书写测试类
    @parameterized.expand(build_data())
    # @parameterized.expand(data)
    def test_login(self, username, password, expect):
        self.assertEqual(expect, login(username, password))
