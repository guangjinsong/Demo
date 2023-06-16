import unittest

version = 30


class TestDemo(unittest.TestCase):
    @unittest.skip("无原因")
    def test_1(self):
        print(1)

    @unittest.skipIf(version >= 30, '版本大于等于30, 不同测试')
    def test_2(self):
        print(1)
