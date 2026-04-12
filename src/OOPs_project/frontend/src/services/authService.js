const AUTH_STORAGE_KEY = "velora-auth-session";

function getInitials(name) {
  return name
    .split(" ")
    .filter(Boolean)
    .slice(0, 2)
    .map((part) => part[0]?.toUpperCase() ?? "")
    .join("");
}

function normalizeUser({ name, email }) {
  const isAdmin = email.trim().toLowerCase() === "admin@velora.club";

  return {
    name,
    email,
    initials: getInitials(name || "Velora User"),
    role: isAdmin ? "Admin" : "Premium Member",
    walletBalance: isAdmin ? 0 : 1250,
    cartCount: isAdmin ? 0 : 3,
    notificationCount: isAdmin ? 2 : 4,
  };
}

export function getStoredSession() {
  if (typeof window === "undefined") {
    return null;
  }

  const rawValue = window.localStorage.getItem(AUTH_STORAGE_KEY);

  if (!rawValue) {
    return null;
  }

  try {
    return JSON.parse(rawValue);
  } catch {
    window.localStorage.removeItem(AUTH_STORAGE_KEY);
    return null;
  }
}

export function saveSession(session) {
  if (typeof window === "undefined") {
    return;
  }

  window.localStorage.setItem(AUTH_STORAGE_KEY, JSON.stringify(session));
}

export function clearSession() {
  if (typeof window === "undefined") {
    return;
  }

  window.localStorage.removeItem(AUTH_STORAGE_KEY);
}

export function loginWithCredentials({ email, password }) {
  const normalizedEmail = email.trim().toLowerCase();

  if (!normalizedEmail || !password.trim()) {
    throw new Error("Email and password are required.");
  }

  const session = normalizeUser({
    name: normalizedEmail === "admin@velora.club" ? "Admin User" : "John Doe",
    email: normalizedEmail,
  });

  saveSession(session);
  return session;
}

export function registerWithCredentials({ fullName, email, password }) {
  if (!fullName.trim() || !email.trim() || !password.trim()) {
    throw new Error("All fields are required.");
  }

  const session = normalizeUser({
    name: fullName.trim(),
    email: email.trim().toLowerCase(),
  });

  saveSession(session);
  return session;
}
