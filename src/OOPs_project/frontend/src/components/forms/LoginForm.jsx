import { useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import Button from "../common/Button";
import Input from "../common/Input";
import useAuth from "../../hooks/useAuth";

export default function LoginForm() {
  const navigate = useNavigate();
  const location = useLocation();
  const { login } = useAuth();
  const [form, setForm] = useState({
    email: "john.doe@velora.club",
    password: "",
  });
  const [error, setError] = useState("");

  const handleChange = (event) => {
    const { name, value } = event.target;

    setForm((current) => ({
      ...current,
      [name]: value,
    }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      setError("");
      const session = await login(form);
      const fallbackPath = session.role === "Admin" ? "/admin" : "/app/dashboard";
      navigate(location.state?.from ?? fallbackPath, { replace: true });
    } catch (submitError) {
      setError(submitError.message);
    }
  };

  return (
    <form className="surface-card p-7 md:p-8" onSubmit={handleSubmit}>
      <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Sign in</p>
      <h2 className="mt-3 text-3xl font-semibold text-ink-900">Welcome back</h2>
      <p className="mt-3 text-sm leading-7 text-ink-500">
        Continue into your premium commerce dashboard, synced wallet, and faster checkout flow.
      </p>

      <div className="mt-8 space-y-5">
        <div>
          <label className="mb-2 block text-sm font-semibold text-ink-800" htmlFor="login-email">
            Email
          </label>
          <Input
            id="login-email"
            name="email"
            onChange={handleChange}
            placeholder="Enter your email"
            type="email"
            value={form.email}
          />
        </div>
        <div>
          <div className="mb-2 flex items-center justify-between gap-4">
            <label className="block text-sm font-semibold text-ink-800" htmlFor="login-password">
              Password
            </label>
            <button className="text-sm font-medium text-brand-600" type="button">
              Forgot?
            </button>
          </div>
          <Input
            id="login-password"
            name="password"
            onChange={handleChange}
            placeholder="Enter your password"
            type="password"
            value={form.password}
          />
        </div>
      </div>

      <div className="mt-5 flex items-center justify-between gap-4 rounded-[1.25rem] bg-ink-50 px-4 py-3">
        <div>
          <p className="text-sm font-semibold text-ink-900">Remember this device</p>
          <p className="mt-1 text-xs text-ink-400">Recommended for personal use only</p>
        </div>
        <div className="flex h-8 w-14 items-center rounded-full bg-brand-500 px-1">
          <span className="ml-auto h-6 w-6 rounded-full bg-white shadow" />
        </div>
      </div>

      {error ? (
        <div className="mt-5 rounded-[1.25rem] border border-rose-200 bg-rose-50 px-4 py-3 text-sm font-medium text-rose-700">
          {error}
        </div>
      ) : null}

      <div className="mt-5 rounded-[1.25rem] bg-brand-50 px-4 py-4">
        <p className="text-sm font-semibold text-brand-700">Demo admin login</p>
        <p className="mt-1 text-xs text-brand-600">
          Use `admin@velora.club` with any password to access the admin route.
        </p>
      </div>

      <Button className="mt-8 w-full" type="submit">
        Sign in to Velora
      </Button>

      <div className="mt-6 text-center text-sm text-ink-500">
        New here?{" "}
        <Link className="font-semibold text-brand-600" to="/register">
          Create an account
        </Link>
      </div>
    </form>
  );
}
