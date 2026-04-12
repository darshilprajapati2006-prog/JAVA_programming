import { createContext, createElement, useContext, useState } from "react";
import {
  clearSession,
  getStoredSession,
  loginWithCredentials,
  registerWithCredentials,
} from "../services/authService";

const AuthContext = createContext(null);

export function AuthProvider({ children }) {
  const [user, setUser] = useState(() => getStoredSession());

  const login = async (credentials) => {
    const session = loginWithCredentials(credentials);
    setUser(session);
    return session;
  };

  const register = async (payload) => {
    const session = registerWithCredentials(payload);
    setUser(session);
    return session;
  };

  const logout = () => {
    clearSession();
    setUser(null);
  };

  const value = {
    user,
    isAuthenticated: Boolean(user),
    isAdmin: user?.role === "Admin",
    login,
    register,
    logout,
  };

  return createElement(AuthContext.Provider, { value }, children);
}

export default function useAuth() {
  const context = useContext(AuthContext);

  if (!context) {
    throw new Error("useAuth must be used within an AuthProvider.");
  }

  return context;
}
