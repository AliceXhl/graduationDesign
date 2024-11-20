import React from 'react';
import { InboxOutlined } from '@ant-design/icons';

import { message, Upload } from 'antd';
import {uploadFile} from '@/services/ant-design-pro/api'


const { Dragger } = Upload;

const props = {
  name: 'file',
  multiple: true,
  onChange(info) {
    const { status } = info.file;
    if (status !== 'uploading') {
      console.log(info.file, info.fileList);
    }
    if (status === 'done') {
      message.success(`${info.file.name} file uploaded successfully.`);
    } else if (status === 'error') {
      message.error(`${info.file.name} file upload failed.`);
    }
  },
  onDrop(e) {
    console.log('Dropped files', e.dataTransfer.files);
  },
  customRequest: async (options) => {
    const { file, onSuccess, onError } = options;

    // 使用 FormData 来上传文件
    const formData = new FormData();
    formData.append('file', file);

    try {
      // 调用 MultiCheck 函数来上传文件
      const response = await uploadFile(formData);

      // 检查响应，假设响应成功时 status 为 200
      if (response.status === 200) {
        onSuccess?.({}, file);
        message.success(`${file.name} file uploaded successfully.`);
      } else {
        throw new Error('Upload failed');
      }
    } catch (error) {
      onError?.(error);
      message.error(`${file.name} file upload failed.`);
    }
  },
};

const App: React.FC = () => (
  <Dragger {...props}>
    <p className="ant-upload-drag-icon">
      <InboxOutlined />
    </p>
    <p className="ant-upload-text">Click or drag file to this area to upload</p>
    <p className="ant-upload-hint">
      Support for a single or bulk upload. Strictly prohibited from uploading company data or other
      banned files.
    </p>
  </Dragger>
);

export default App;
