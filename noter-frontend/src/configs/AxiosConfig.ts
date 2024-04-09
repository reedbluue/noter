import axios from 'axios';
import {VITE_BASE_URL} from "./Env.ts";

export const baseUrl = axios.create({
  baseURL: VITE_BASE_URL
})