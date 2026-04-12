import { Link } from "react-router-dom";
import LoginForm from "../../components/forms/LoginForm";
import { dummyData } from "../../constants/dummyData";

export default function Login() {
  return (
    <main className="page-shell">
      <div className="content-wrap grid gap-6 xl:grid-cols-[1.05fr_0.95fr]">
        <section className="rounded-[2.5rem] bg-gradient-to-br from-ink-900 via-brand-900 to-brand-500 p-8 text-white shadow-[0_32px_90px_rgba(15,23,42,0.25)] md:p-12">
          <span className="inline-flex rounded-full bg-white/10 px-4 py-2 text-xs font-semibold uppercase tracking-[0.2em] text-white/78">
            Premium Access
          </span>
          <h1 className="mt-6 max-w-xl text-5xl font-semibold leading-tight tracking-tight md:text-6xl">
            Sign in to your commerce command center
          </h1>
          <p className="mt-5 max-w-2xl text-base leading-8 text-white/80">
            Access orders, wallet, rewards, curated collections, and faster checkout from a single premium account environment.
          </p>

          <div className="mt-10 grid gap-4 md:grid-cols-3">
            {dummyData.authStats.map((item) => (
              <div key={item.label} className="rounded-[1.75rem] bg-white/10 p-5 backdrop-blur-sm">
                <p className="text-3xl font-semibold text-white">{item.value}</p>
                <p className="mt-2 text-sm text-white/72">{item.label}</p>
              </div>
            ))}
          </div>

          <div className="mt-10 rounded-[2rem] bg-white/8 p-6 backdrop-blur-sm">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/72">Why sign in</p>
            <div className="mt-5 space-y-4">
              {dummyData.authHighlights.map((item) => (
                <div key={item} className="flex items-start gap-3">
                  <span className="mt-1 h-2.5 w-2.5 rounded-full bg-white" />
                  <p className="text-sm leading-7 text-white/82">{item}</p>
                </div>
              ))}
            </div>
          </div>

          <p className="mt-8 text-sm text-white/68">
            Looking for the storefront first?{" "}
            <Link className="font-semibold text-white" to="/shop">
              Browse the catalog
            </Link>
          </p>
        </section>

        <section className="flex items-center">
          <LoginForm />
        </section>
      </div>
    </main>
  );
}
