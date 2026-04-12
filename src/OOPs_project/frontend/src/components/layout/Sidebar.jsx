import { NavLink } from "react-router-dom";
import { navSections } from "../../constants/navLinks";
import useAuth from "../../hooks/useAuth";

function SidebarIcon({ icon }) {
  const common = "h-5 w-5";

  switch (icon) {
    case "dashboard":
      return (
        <svg className={common} fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
          <path d="M4 4h7v7H4zM13 4h7v4h-7zM13 10h7v10h-7zM4 13h7v7H4z" />
        </svg>
      );
    case "shop":
      return (
        <svg className={common} fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
          <path d="M4 7h16l-1.5 11h-13z" />
          <path d="M9 7a3 3 0 0 1 6 0" />
        </svg>
      );
    case "collections":
      return (
        <svg className={common} fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
          <path d="M4 6h16M4 12h16M4 18h10" />
        </svg>
      );
    case "orders":
      return (
        <svg className={common} fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
          <path d="M6 4h12v16H6z" />
          <path d="M9 8h6M9 12h6M9 16h4" />
        </svg>
      );
    case "wallet":
      return (
        <svg className={common} fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
          <path d="M4 7h14a2 2 0 0 1 2 2v8H6a2 2 0 0 1-2-2z" />
          <path d="M16 13h4" />
          <path d="M6 7V6a2 2 0 0 1 2-2h10" />
        </svg>
      );
    case "notifications":
      return (
        <svg className={common} fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
          <path d="M6 10a6 6 0 1 1 12 0v4l2 2H4l2-2z" />
          <path d="M10 20a2 2 0 0 0 4 0" />
        </svg>
      );
    case "profile":
      return (
        <svg className={common} fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
          <path d="M12 12a4 4 0 1 0-4-4 4 4 0 0 0 4 4Z" />
          <path d="M5 20a7 7 0 0 1 14 0" />
        </svg>
      );
    default:
      return (
        <svg className={common} fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
          <path d="M4 12h16" />
        </svg>
      );
  }
}

export default function Sidebar({ mobileOpen, onClose }) {
  const { isAdmin, logout, user } = useAuth();
  const visibleSections = navSections.map((section) => ({
    ...section,
    items: section.items.filter((item) => item.icon !== "admin" || isAdmin),
  }));

  return (
    <>
      <div
        aria-hidden={!mobileOpen}
        className={`fixed inset-0 z-30 bg-ink-900/50 transition md:hidden ${mobileOpen ? "opacity-100" : "pointer-events-none opacity-0"}`}
        onClick={onClose}
      />
      <aside
        className={`fixed inset-y-0 left-0 z-40 flex w-[288px] flex-col bg-[#121a2d] px-6 py-8 text-white shadow-2xl transition duration-300 md:sticky md:top-0 md:h-screen md:translate-x-0 ${
          mobileOpen ? "translate-x-0" : "-translate-x-full"
        }`}
      >
        <div className="flex items-center gap-4">
          <div className="flex h-14 w-14 items-center justify-center rounded-2xl bg-brand-500 shadow-[0_16px_30px_rgba(54,92,255,0.35)]">
            <svg className="h-7 w-7" fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
              <path d="M6 16V8a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v8" />
              <path d="M4 16h16" />
              <path d="M8 20h8" />
              <path d="M8.5 10h.01M15.5 10h.01" />
            </svg>
          </div>
          <div>
            <p className="text-3xl font-semibold tracking-tight text-white">Velora</p>
            <p className="mt-1 text-sm text-brand-100/80">Premium Commerce</p>
          </div>
        </div>

        <nav className="mt-10 flex-1 space-y-8">
          {visibleSections.map((section) => (
            <div key={section.title}>
              <p className="px-3 text-xs font-semibold uppercase tracking-[0.24em] text-white/35">{section.title}</p>
              <div className="mt-3 space-y-1.5">
                {section.items.map((item) => (
                  <NavLink
                    key={item.to}
                    className={({ isActive }) =>
                      `flex items-center gap-3 rounded-2xl px-4 py-3 text-base font-medium transition ${
                        isActive
                          ? "bg-brand-500 text-white shadow-[0_20px_36px_rgba(54,92,255,0.35)]"
                          : "text-white/72 hover:bg-white/6 hover:text-white"
                      }`
                    }
                    onClick={onClose}
                    to={item.to}
                  >
                    <SidebarIcon icon={item.icon} />
                    <span>{item.label}</span>
                  </NavLink>
                ))}
              </div>
            </div>
          ))}
        </nav>

        <div className="rounded-[1.75rem] border border-white/10 bg-white/6 p-5">
          <p className="text-sm font-semibold text-white">{user?.name ?? "Velora Member"}</p>
          <p className="mt-1 text-sm text-white/65">{user?.role ?? "Premium Commerce Access"}</p>
          <button
            className="mt-4 w-full rounded-full border border-white/12 px-4 py-3 text-sm font-semibold text-white transition hover:bg-white/8"
            onClick={() => {
              logout();
              onClose?.();
            }}
            type="button"
          >
            Logout
          </button>
        </div>
      </aside>
    </>
  );
}
