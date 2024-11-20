import { PageContainer } from '@ant-design/pro-components';
import { useModel } from '@umijs/max';
import { ArrowDownOutlined, ArrowUpOutlined } from '@ant-design/icons';
import { Avatar, Divider, List, Skeleton, Card, Col, Row, Statistic } from 'antd';
import { theme } from 'antd';
import React, {useEffect, useState} from 'react';
import styled from "styled-components";
import MyChart from '@/components/Echart/Demo'; // 确保路径正确
import InfiniteScroll from 'react-infinite-scroll-component';
import './CSS/MyPage.css';
import {visualData} from "@/services/ant-design-pro/api"; // 引入 CSS 文件


interface DataType {
  gender: string;
  name: {
    title: string;
    first: string;
    last: string;
  };
  email: string;
  picture: {
    large: string;
    medium: string;
    thumbnail: string;
  };
  nat: string;
}
const Welcome: React.FC = () => {
  const { token } = theme.useToken();
  const { initialState } = useModel('@@initialState');
  const Container = styled.div`
    display: flex;
    height: 100vh;
  `;

  const Panel = styled.div`
    flex: 1;
    height: calc(100% - 10px); /* 减去间隔 */
    //background-color: #FF5733; /* 第一部分 - 橙色 */
    margin: 5px; /* 增加间隔 */
  `;

  const VerticalContainer = styled.div`
    display: flex;
    flex-direction: column;
    flex: 1;
    margin: 5px; /* 增加间隔 */
  `;

  const VerticalPanel = styled.div<{ color: string }>`
    flex: 1;
    background-color: ${({ color }) => color}; /* 根据传入的颜色设置背景 */
    margin: 5px; /* 增加间隔 */
  `;

  // 使用 useState 来存储从后端获取的数据
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // 请求后端接口并更新数据
  const fetchData = async () => {
    try {
      setLoading(true); // 请求开始时设置 loading 为 true
      const response = await visualData();
      console.log("可数据界面数据：", response);
      if (response.message != "ok") {
        throw new Error('Failed to fetch data');
      }
      const result = await response.data;
      setData(result); // 更新数据状态
      setLoading(false); // 请求结束后，设置 loading 为 false
    } catch (error) {
      setError(error.message); // 如果发生错误，设置错误状态
      setLoading(false);
    }
  };

  // 使用 useEffect 来启动定时器，定时每隔 2 秒请求一次数据
  useEffect(() => {
    // 启动定时请求
    const intervalId = setInterval(fetchData, 5000);

    // 清除定时器
    return () => {
      clearInterval(intervalId);
    };
  }, []); // 空依赖数组，表示只在组件首次渲染时启动定时器

  return (''
      // <Container>
      //   <Panel style={{
      //     display: 'flex',
      //     flexDirection: 'column',
      //   }}>
      //     <div className="section one-third">
      //       <div className="site-statistic-demo-card">
      //         <Row gutter={12}>
      //           <Col span={12}>
      //             <Card>
      //               <Statistic
      //                 title="Health"
      //                 value={data}
      //                 valueStyle={{ color: '#3f8600' }}
      //               />
      //             </Card>
      //           </Col>
      //           <Col span={12}>
      //             <Card>
      //               <Statistic
      //                 title="Suffer"
      //                 value={"1.3万"}
      //                 valueStyle={{ color: '#cf1322' }}
      //               />
      //             </Card>
      //           </Col>
      //         </Row>
      //       </div>
      //     </div>
      //     <div className="section two-thirds">
      //
      //       <div
      //         id="scrollableDiv"
      //         style={{
      //           height: '100%',
      //           width: '100%',
      //           overflow: 'auto',
      //           padding: '0 16px',
      //           border: '1px solid rgba(140, 140, 140, 0.35)',
      //         }}
      //       >
      //         <InfiniteScroll
      //           dataLength={"data.length"}
      //           next={"loadMoreData"}
      //           hasMore={"data.length < 50"}
      //           loader={<Skeleton avatar paragraph={{ rows: 1 }} active />}
      //           endMessage={<Divider plain>It is all, nothing more 🤐</Divider>}
      //           scrollableTarget="scrollableDiv"
      //         >
      //           <List
      //             dataSource={data}
      //             renderItem={item => (
      //               <List.Item key={item.email}>
      //                 <List.Item.Meta
      //                   avatar={<Avatar src={item.picture.large} />}
      //                   title={<a href="https://ant.design">{item.name.last}</a>}
      //                   description={item.email}
      //                 />
      //                 <div>Content</div>
      //               </List.Item>
      //             )}
      //           />
      //         </InfiniteScroll>
      //       </div>
      //
      //     </div>
      //   </Panel>
      //   <VerticalContainer>
      //     <VerticalPanel>
      //       <MyChart />
      //     </VerticalPanel>
      //     <VerticalPanel>
      //       <MyChart />
      //     </VerticalPanel>
      //   </VerticalContainer>
      //   <VerticalContainer>
      //     <VerticalPanel>
      //       <MyChart />
      //     </VerticalPanel>
      //     <VerticalPanel>
      //       <MyChart />
      //     </VerticalPanel>
      //   </VerticalContainer>
      //   <VerticalContainer>
      //     <VerticalPanel>
      //       <MyChart />
      //     </VerticalPanel>
      //     <VerticalPanel>
      //       <MyChart />
      //     </VerticalPanel>
      //   </VerticalContainer>
      // </Container>
  );
};

export default Welcome;
