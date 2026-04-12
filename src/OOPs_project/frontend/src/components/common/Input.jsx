export default function Input({ className = "", ...props }) {
  return (
    <input
      className={`w-full rounded-[1.25rem] border border-brand-100 bg-white px-4 py-3 text-base text-ink-900 outline-none transition placeholder:text-ink-300 focus:border-brand-300 focus:ring-4 focus:ring-brand-100/70 ${className}`.trim()}
      {...props}
    />
  );
}
