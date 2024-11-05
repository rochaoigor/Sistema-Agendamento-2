import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080',
});

export const login = async (email, senha) => {
  return await api.post('/login', { email, senha });
};
export const fetchAgendamento = () => api.get('/agendamentos'); 