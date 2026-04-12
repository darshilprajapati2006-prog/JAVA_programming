export default function Select({ className = "", options = [], placeholder = "Select an option", ...props }) {
  return (
    <select
      className={`w-full rounded-[1.25rem] border border-brand-100 bg-white px-4 py-3 text-base text-ink-900 outline-none transition focus:border-brand-300 focus:ring-4 focus:ring-brand-100/70 ${className}`.trim()}
      {...props}
    >
      <option value="">{placeholder}</option>
      {options.map((option) => (
        <option key={option.value} value={option.value}>
          {option.label}
        </option>
      ))}
    </select>
  );
}
