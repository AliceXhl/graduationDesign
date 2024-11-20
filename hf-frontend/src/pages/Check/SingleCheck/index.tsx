import {
  ProForm,
  ProFormCascader,
  ProFormCheckbox,
  ProFormColorPicker,
  ProFormDigit,
  ProFormDigitRange,
  ProFormGroup,
  ProFormRadio,
  ProFormRate,
  ProFormSegmented,
  ProFormSelect,
  ProFormSlider,
  ProFormSwitch,
  ProFormText,
} from '@ant-design/pro-components';
import { Switch } from 'antd';
import { useState } from 'react';

export const waitTime = (time: number = 100) => {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve(true);
    }, time);
  });
};

const Demo = () => {
  const [readonly, setReadonly] = useState(false);
  return (
    <div
      style={{
        padding: 24,
      }}
    >
      <Switch
        style={{
          marginBlockEnd: 16,
        }}
        checked={readonly}
        checkedChildren="编辑"
        unCheckedChildren="只读"
        onChange={setReadonly}
      />
      <ProForm
        readonly={readonly}
        name="validate_other"
        initialValues={{
          name: '',
          password: '',
          select: 'china',
          select2: '520000201604258831',
          useMode: { label: '未解决', value: 'open', key: 'open' },
          'select-multiple': ['green', 'blue'],
          radio: 'a',
          'radio-vertical': 'b',
          'radio-button': 'b',
          'checkbox-group': ['A', 'B', 'C'],
          'input-number-range': [2, 4],
          'input-number': 3,
          switch: true,
          slider: 66,
          rate: 3.5,
          segmented: 'open',
          segmented2: 'open',
        }}
        onValuesChange={(_, values) => {
          console.log(values);
        }}
        onFinish={async (value) => console.log(value)}
      >
        <ProFormGroup title="用户信息">
          <ProFormText width="md" name="name" label="姓名" />
          <ProFormText width="md" name="photo" label="电话" />
        </ProFormGroup>
        <ProFormGroup title="关键信息">
          <ProFormSelect
            name="sex"
            label="性别"
            valueEnum={{
              Male: 'Male',
              Female: 'Female',
            }}
            placeholder="Please select a sex"
            rules={[{ required: true, message: 'Please select your sex!' }]}
          />
          <ProFormSelect
            name="ageCategery"
            label="年龄范围"
            valueEnum={{
              1: '18-24',
              2: '25-29',
              3: '30-34',
              4: '35-39',
              5: '40-44',
              6: '45-49',
              7: '50-54',
              8: '55-59',
              9: '60-64',
              10: '65-69',
              11: '70-74',
              12: '75-79',
              13: '80 or older',
            }}
            placeholder="Please select a categery"
            rules={[{ required: true, message: 'Please select your categery!' }]}
          />
          <ProFormSelect
            width="md"
            fieldProps={{
              labelInValue: true,
            }}
            request={async () => [
              { label: '全部', value: 'all' },
              { label: '未解决', value: 'open' },
              { label: '已解决', value: 'closed' },
              { label: '解决中', value: 'processing' },
            ]}
            name="useMode"
            label="合同约定生效方式"
          />
          <ProFormSelect
            name="select-multiple"
            label="Select[multiple]"
            valueEnum={{
              red: 'Red',
              green: 'Green',
              blue: 'Blue',
            }}
            fieldProps={{
              mode: 'multiple',
            }}
            placeholder="Please select favorite colors"
            rules={[
              {
                required: true,
                message: 'Please select your favorite colors!',
                type: 'array',
              },
            ]}
          />
          <ProFormCascader
            label="地址"
            request={async () => [
              {
                value: 'zhejiang',
                label: '浙江',
                children: [
                  {
                    value: 'hangzhou',
                    label: '杭州',
                    children: [
                      {
                        value: 'xihu',
                        label: '西湖',
                      },
                    ],
                  },
                ],
              },
              {
                value: 'jiangsu',
                label: 'Jiangsu',
                children: [
                  {
                    value: 'nanjing',
                    label: 'Nanjing',
                    children: [
                      {
                        value: 'zhonghuamen',
                        label: 'Zhong Hua Men',
                      },
                    ],
                  },
                ],
              },
            ]}
            fieldProps={{
              changeOnSelect: true,
            }}
            name="area"
          />

          <ProFormRadio.Group
            name="radio"
            label="Radio.Group"
            options={[
              {
                label: 'item 1',
                value: 'a',
              },
              {
                label: 'item 2',
                value: 'b',
              },
              {
                label: 'item 3',
                value: 'c',
              },
            ]}
          />
          <ProFormRadio.Group
            name="radio-vertical"
            layout="vertical"
            label="Radio.Group"
            options={[
              {
                label: 'item 1',
                value: 'a',
              },
              {
                label: 'item 2',
                value: 'b',
              },
              {
                label: 'item 3',
                value: 'c',
              },
            ]}
          />
          <ProFormRadio.Group
            name="radio-button"
            label="Radio.Button"
            radioType="button"
            options={[
              {
                label: 'item 1',
                value: 'a',
              },
              {
                label: 'item 2',
                value: 'b',
              },
              {
                label: 'item 3',
                value: 'c',
              },
            ]}
          />
          <ProFormCheckbox.Group
            name="checkbox-group"
            label="Checkbox.Group"
            options={['A', 'B', 'C', 'D', 'E', 'F']}
          />
          <ProFormColorPicker label="颜色选择" name="color" />
        </ProFormGroup>
        <ProFormGroup label="数字类">
          <ProFormDigitRange
            label="InputNumberRange"
            name="input-number-range"
            separator="-"
            placeholder={['最小值', '最大值']}
            separatorWidth={60}
          />
          <ProFormDigit
            label="InputNumber"
            name="input-number"
            width="sm"
            min={1}
            max={10}
          />
          <ProFormSwitch name="switch" label="Switch" />
          <ProFormSlider
            name="slider"
            label="Slider"
            width="lg"
            marks={{
              0: 'A',
              20: 'B',
              40: 'C',
              60: 'D',
              80: 'E',
              100: 'F',
            }}
          />
          <ProFormRate name="rate" label="Rate" />
          <ProFormSegmented
            name="segmented"
            label="分段控制器"
            valueEnum={{
              open: '未解决',
              closed: '已解决',
            }}
          />
          <ProFormSegmented
            name="segmented2"
            label="分段控制器-远程数据"
            request={async () => [
              { label: '全部', value: 'all' },
              { label: '未解决', value: 'open' },
              { label: '已解决', value: 'closed' },
              { label: '解决中', value: 'processing' },
            ]}
          />
        </ProFormGroup>
      </ProForm>
    </div>
  );
};

export default Demo;
