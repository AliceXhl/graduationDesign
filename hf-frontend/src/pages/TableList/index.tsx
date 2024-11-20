import React from 'react';
import { Flex, Layout } from 'antd';
import SearckBox from './components/SearchBox';
import UserListBox from './components/UserListBox';

const { Header, Content } = Layout;

const headerStyle: React.CSSProperties = {
  color: '#fff',
  display: 'flex',
  flex: 1,
  alignItems: 'center',
  paddingInline: 24,
  lineHeight: '64px',
  backgroundColor: 'white',
  marginBlockEnd: '25px',
};

const contentStyle: React.CSSProperties = {
  flex: 7,
  paddingInline: 24,
  // height: '100%',
  // lineHeight: '120px',
  // color: '#fff',
  // backgroundColor: '#0958d9',
};

const layoutStyle = {
  borderRadius: 8,
  overflow: 'hidden',
  width: '100%',
};

const App: React.FC = () => (
  <Flex gap="middle" wrap>
    <Layout style={layoutStyle}>
      <Header style={headerStyle}>
        <SearckBox />
      </Header>
      <Content style={contentStyle}>
        <UserListBox style={{
          height: '100%'
        }}></UserListBox>
      </Content>
    </Layout>
  </Flex>
);

export default App;
