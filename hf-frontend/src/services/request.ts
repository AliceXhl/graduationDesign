import axios from "axios";

const request = axios.create({
  baseURL: 'http://localhost:8101/api/',
  timeout: 5000,
  headers: {}
});

export default request;
