export default function Loader({ label = "Loading", className = "" }) {
  return (
    <div className={`inline-flex items-center gap-3 text-sm font-medium text-ink-500 ${className}`.trim()} role="status">
      <span className="h-5 w-5 animate-spin rounded-full border-2 border-brand-200 border-t-ink-900" />
      <span>{label}</span>
    </div>
  );
}
