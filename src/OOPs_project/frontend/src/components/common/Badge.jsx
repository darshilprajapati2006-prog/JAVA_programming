export default function Badge({ children, className = "" }) {
  return (
    <span
      className={`inline-flex items-center rounded-full px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] ${className}`.trim()}
    >
      {children}
    </span>
  );
}
