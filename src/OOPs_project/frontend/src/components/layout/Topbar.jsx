import { Link } from "react-router-dom";
import { dummyData } from "../../constants/dummyData";
import useAuth from "../../hooks/useAuth";

function IconButton({ children, badge }) {
  return (
    <button
      className="relative inline-flex h-12 w-12 items-center justify-center rounded-2xl bg-white text-ink-600 shadow-[var(--shadow-soft-md)] transition hover:-translate-y-0.5 hover:text-ink-900"
      type="button"
    >
      {badge ? <span className="absolute right-2 top-2 h-2.5 w-2.5 rounded-full bg-rose-500" /> : null}
      {children}
    </button>
  );
}

export default function Topbar({ onOpenSidebar }) {
  const { user } = useAuth();
  const currentUser = user ?? dummyData.currentUser;

  return (
    <header className="sticky top-0 z-20 flex items-center gap-3 rounded-[2rem] border border-white/60 bg-white/88 p-4 shadow-[var(--shadow-soft-md)] backdrop-blur-xl">
      <button
        className="inline-flex h-12 w-12 items-center justify-center rounded-2xl bg-ink-900 text-white md:hidden"
        onClick={onOpenSidebar}
        type="button"
      >
        <svg className="h-6 w-6" fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
          <path d="M4 7h16M4 12h16M4 17h16" />
        </svg>
      </button>

      <div className="hidden min-w-0 flex-1 items-center gap-3 rounded-[1.4rem] bg-ink-50 px-5 py-3 md:flex">
        <svg className="h-5 w-5 shrink-0 text-ink-300" fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
          <path d="m21 21-4.35-4.35" />
          <circle cx="11" cy="11" r="6" />
        </svg>
        <input
          className="w-full border-none bg-transparent text-base text-ink-900 outline-none placeholder:text-ink-300"
          placeholder="Search products, collections, orders..."
          type="text"
        />
      </div>

      <div className="ml-auto flex items-center gap-3">
        <Link
          className="hidden items-center gap-2 rounded-2xl bg-brand-500 px-4 py-3 text-sm font-semibold text-white shadow-[0_20px_36px_rgba(54,92,255,0.28)] sm:inline-flex"
          to="/app/wallet"
        >
          <svg className="h-4 w-4" fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
            <path d="M4 7h14a2 2 0 0 1 2 2v8H6a2 2 0 0 1-2-2z" />
            <path d="M16 13h4" />
          </svg>
          Rs {currentUser.walletBalance.toLocaleString("en-IN")}
        </Link>
        <IconButton badge>
          <svg className="h-5 w-5" fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
            <path d="M6 10a6 6 0 1 1 12 0v4l2 2H4l2-2z" />
            <path d="M10 20a2 2 0 0 0 4 0" />
          </svg>
        </IconButton>
        <Link
          className="flex items-center gap-3 rounded-[1.4rem] bg-white px-3 py-2 shadow-[var(--shadow-soft-md)]"
          to="/app/profile"
        >
          <div className="flex h-12 w-12 items-center justify-center rounded-2xl bg-gradient-to-br from-brand-500 to-violet-500 text-sm font-semibold text-white">
            {currentUser.initials}
          </div>
          <div className="hidden text-left sm:block">
            <p className="text-sm font-semibold text-ink-900">{currentUser.name}</p>
            <p className="text-xs text-ink-400">{currentUser.role}</p>
          </div>
        </Link>
      </div>
    </header>
  );
}
