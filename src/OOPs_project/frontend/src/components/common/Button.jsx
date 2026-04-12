import { Link } from "react-router-dom";

const toneClasses = {
  primary: "bg-ink-900 text-white shadow-[0_18px_32px_rgba(17,17,17,0.16)] hover:bg-brand-500",
  secondary: "bg-white text-ink-900 ring-1 ring-inset ring-brand-200 hover:bg-brand-50",
  ghost: "bg-transparent text-ink-600 hover:bg-white/70 hover:text-ink-900",
};

export default function Button({
  children,
  className = "",
  tone = "primary",
  to,
  type = "button",
  ...props
}) {
  const classes = `inline-flex items-center justify-center rounded-full px-5 py-3 text-sm font-semibold transition duration-200 hover:-translate-y-0.5 ${toneClasses[tone] ?? toneClasses.primary} ${className}`.trim();

  if (to) {
    return (
      <Link className={classes} to={to} {...props}>
        {children}
      </Link>
    );
  }

  return (
    <button className={classes} type={type} {...props}>
      {children}
    </button>
  );
}
