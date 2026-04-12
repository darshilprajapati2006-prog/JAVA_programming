import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Button from "../common/Button";
import Input from "../common/Input";
import useAuth from "../../hooks/useAuth";

export default function RegisterForm() {
  const navigate = useNavigate();
  const { register } = useAuth();
  const [form, setForm] = useState({
    fullName: "",
    email: "",
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
      await register(form);
      navigate("/app/dashboard", { replace: true });
    } catch (submitError) {
      setError(submitError.message);
    }
  };

  return (
    <form className="surface-card p-7 md:p-8" onSubmit={handleSubmit}>
      <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Create account</p>
      <h2 className="mt-3 text-3xl font-semibold text-ink-900">Join Velora</h2>
      <p className="mt-3 text-sm leading-7 text-ink-500">
        Start your premium shopping profile with synced wallet, faster checkout, and curated commerce access.
      </p>

      <div className="mt-8 space-y-5">
        <div>
          <label className="mb-2 block text-sm font-semibold text-ink-800" htmlFor="register-name">
            Full name
          </label>
          <Input
            id="register-name"
            name="fullName"
            onChange={handleChange}
            placeholder="Enter your full name"
            type="text"
            value={form.fullName}
          />
        </div>
        <div>
          <label className="mb-2 block text-sm font-semibold text-ink-800" htmlFor="register-email">
            Email
          </label>
          <Input
            id="register-email"
            name="email"
            onChange={handleChange}
            placeholder="Enter your email"
            type="email"
            value={form.email}
          />
        </div>
        <div>
          <label className="mb-2 block text-sm font-semibold text-ink-800" htmlFor="register-password">
            Password
          </label>
          <Input
            id="register-password"
            name="password"
            onChange={handleChange}
            placeholder="Create a strong password"
            type="password"
            value={form.password}
          />
        </div>
      </div>

      <div className="mt-5 rounded-[1.25rem] bg-ink-50 px-4 py-4">
        <p className="text-sm font-semibold text-ink-900">By continuing you agree to the premium account terms</p>
        <p className="mt-1 text-xs text-ink-400">Includes order updates, reward tracking, and secure account access.</p>
      </div>

      {error ? (
        <div className="mt-5 rounded-[1.25rem] border border-rose-200 bg-rose-50 px-4 py-3 text-sm font-medium text-rose-700">
          {error}
        </div>
      ) : null}

      <Button className="mt-8 w-full" type="submit">
        Create premium account
      </Button>

      <div className="mt-6 text-center text-sm text-ink-500">
        Already have an account?{" "}
        <Link className="font-semibold text-brand-600" to="/login">
          Sign in
        </Link>
      </div>
    </form>
  );
}
