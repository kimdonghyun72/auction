// src/pages/Register.jsx
import { useState } from "react";
import axios from "axios";

export default function Register() {
  const [form, setForm] = useState({
    username: "",
    password: "",
    confirmPassword: "",
    email: "",
    name: "",
    phone: ""
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (form.password !== form.confirmPassword) {
      alert("비밀번호가 일치하지 않습니다.");
      return;
    }

    try {
      await axios.post("http://localhost:8080/api/register", form);
      alert("회원가입 성공!");
    } catch (err) {
      alert("회원가입 실패: " + err.response?.data?.message || err.message);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="username" placeholder="아이디" onChange={handleChange} required />
      <input type="password" name="password" placeholder="비밀번호" onChange={handleChange} required />
      <input type="password" name="confirmPassword" placeholder="비밀번호 확인" onChange={handleChange} required />
      <input type="email" name="email" placeholder="이메일" onChange={handleChange} required />
      <input name="name" placeholder="이름" onChange={handleChange} required />
      <input name="phone" placeholder="전화번호" onChange={handleChange} />
      <button type="submit">회원가입</button>
    </form>
  );
}
