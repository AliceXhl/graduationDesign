import React, { useEffect, useState } from 'react';
import { UserOutlined } from '@ant-design/icons';
import { Button, Form, Input } from 'antd';
import '@/pages/CSS/MyPage.css'

const SearchBox: React.FC = () => {
  const [form] = Form.useForm();
  const [clientReady, setClientReady] = useState<boolean>(false);

  // To disable submit button at the beginning.
  useEffect(() => {
    setClientReady(true);
  }, []);

  const onFinish = (values: any) => {
    console.log('Finish:', values);  // 这里输出所有表单的值
  };

  const handlerClick = () => {
    form.submit();  // 触发表单提交
  };

  return (
    <Form
      form={form}
      name="horizontal_login"
      layout="inline"
      onFinish={onFinish}
      style={{
        width: '100%',
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-between',
      }}
    >
      <div style={{
        display: 'flex',
        width: '100%',
        flex: 5,
        flexDirection: 'row',
      }}>
        <Form.Item
          className={'SearchBox'}
          name="username"
          rules={[{ required: true, message: 'Please input your username!' }]}
        >
          <Input prefix={<UserOutlined />} placeholder="Username" />
        </Form.Item>
        <Form.Item
          className={'SearchBox'}
          name="userNumber"
          rules={[{ required: true, message: 'Please input your userNumber!' }]}
        >
          <Input prefix={<UserOutlined />} placeholder="User Number" />
        </Form.Item>
        <Form.Item
          className={'SearchBox'}
          name="userAge"
        >
          <Input prefix={<UserOutlined />} placeholder="User Age" />
        </Form.Item>
      </div>
      <div style={{ flex: 1 }}>
        <Form.Item shouldUpdate>
          {() => (
            <Button
              type="primary"
              htmlType="submit"
              disabled={
                !clientReady ||
                !form.isFieldsTouched(true) ||
                !!form.getFieldsError().filter(({ errors }) => errors.length).length
              }
              onClick={handlerClick}  // 按钮点击时触发表单提交
            >
              查询
            </Button>
          )}
        </Form.Item>
      </div>
    </Form>
  );
};

export default SearchBox;
