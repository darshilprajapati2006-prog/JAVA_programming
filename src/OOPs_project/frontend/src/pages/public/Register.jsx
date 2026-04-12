import { Link } from "react-router-dom";
import RegisterForm from "../../components/forms/RegisterForm";
import { dummyData } from "../../constants/dummyData";

export default function Register() {
  return (
    <main className="page-shell">
      <div className="content-wrap grid gap-6 xl:grid-cols-[0.98fr_1.02fr]">
        <section className="flex items-center">
          <RegisterForm />
        </section>

        <section className="rounded-[2.5rem] bg-gradient-to-br from-brand-500 via-violet-500 to-ink-900 p-8 text-white shadow-[0_32px_90px_rgba(15,23,42,0.25)] md:p-12">
          <span className="inline-flex rounded-full bg-white/12 px-4 py-2 text-xs font-semibold uppercase tracking-[0.2em] text-white/80">
            Member Onboarding
          </span>
          <h1 className="mt-6 max-w-xl text-5xl font-semibold leading-tight tracking-tight md:text-6xl">
            Create an account built for repeat premium shopping
          </h1>
          <p className="mt-5 max-w-2xl text-base leading-8 text-white/82">
            Registration should feel like unlocking a better commerce experience: smarter checkout, saved preferences, wallet rewards, and curated product access.
          </p>

          <div className="mt-10 space-y-4">
            {dummyData.registerHighlights.map((item) => (
              <div key={item} className="flex items-start gap-3 rounded-[1.5rem] bg-white/10 p-5 backdrop-blur-sm">
                <span className="mt-1 h-2.5 w-2.5 rounded-full bg-white" />
                <p className="text-sm leading-7 text-white/84">{item}</p>
              </div>
            ))}
          </div>

          <div className="mt-10 grid gap-4 md:grid-cols-3">
            {dummyData.authStats.map((item) => (
              <div key={item.label} className="rounded-[1.75rem] bg-white/10 p-5 backdrop-blur-sm">
                <p className="text-3xl font-semibold text-white">{item.value}</p>
                <p className="mt-2 text-sm text-white/72">{item.label}</p>
              </div>
            ))}
          </div>

          <p className="mt-8 text-sm text-white/70">
            Want to look around first?{" "}
            <Link className="font-semibold text-white" to="/shop">
              Explore the catalog
            </Link>
          </p>
        </section>
      </div>
    </main>
  );
}
